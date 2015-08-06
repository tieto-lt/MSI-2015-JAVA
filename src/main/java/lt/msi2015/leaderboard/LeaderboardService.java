package lt.msi2015.leaderboard;

import java.util.ArrayList;
import java.util.Calendar;
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
		
		return new ArrayList<LeaderboardEntryDto>(map.values());
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

}
