package lt.msi2015.leaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.points_transfer_info.PointsTransferInfo;
import lt.msi2015.points_transfer_info.PointsTransferInfoRepository;

@Service
public class LeaderboardService {
	
	@Autowired
	PointsTransferInfoRepository pointTransfers;
	
	@Transactional
	List<LeaderboardEntryDto> getLeaderboardEntries() {
		
		Iterable<PointsTransferInfo> transfers = pointTransfers.findAll();
		
		Map<String, LeaderboardEntryDto> map = new HashMap<String, LeaderboardEntryDto>();
		
		Iterator<PointsTransferInfo> i = transfers.iterator();
		
		Date monthBefore = oneMonthBefore();
		
		
		while (i.hasNext()) {
			PointsTransferInfo info = i.next();
			
			String key = info.toUser;
			
			if (info.dateCreated.after(monthBefore)) {
				addToResponse(map, info, key);
			}
			
		}
		
		ArrayList<LeaderboardEntryDto> leaders = getTopFive(map.values());
		
		return leaders;// getTopFive(map.values());
	}
	
	
	
	private Date oneMonthBefore(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}
	
	private void addToResponse(
		Map<String, LeaderboardEntryDto> map,
		PointsTransferInfo info,
		String key
	){
		if (map.get(key) == null)
			map.put(key, new LeaderboardEntryDto(key, info.points));
		else
			map.get(key).points += info.points;
	}
	
	private ArrayList<LeaderboardEntryDto> getTopFive(Collection<LeaderboardEntryDto> collection) {
		ArrayList<LeaderboardEntryDto> entries = new ArrayList<LeaderboardEntryDto>(collection);
		entries.sort(new Comparator<LeaderboardEntryDto>() {

			@Override
			public int compare(LeaderboardEntryDto o1, LeaderboardEntryDto o2) {
				long points1 = o1.points;
				long points2 = o2.points;
				
				if (points1 == points2)
	    			return 0;
	    		else if (points1 < points2)
	    			return 1;
	    		else
	    			return -1;
			}
		});
		
		return new ArrayList<LeaderboardEntryDto>(entries.subList(0, 5 > entries.size() ? entries.size() : 5));
	}

}
