package lt.msi2015.leaderboard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.pointsTransferInfo.PointsTransferInfo;
import lt.msi2015.pointsTransferInfo.PointsTransferInfoRepository;

@Service
public class LeaderboardService {
	
	@Autowired
	PointsTransferInfoRepository pointTransfers;
	
	@Transactional
	List<LeaderboardEntryDto> getLeaderboardEntries() {

		Map<String, LeaderboardEntryDto> groupedLeaders = new HashMap<>();
		
		for (PointsTransferInfo historyEntry : pointTransfers.findAll()) {
			if (historyEntry.dateCreated.after(getMonthBefore()))
				addToGroupedLeaders(groupedLeaders, historyEntry);			
		}
		
		return getTopFive(groupedLeaders.values());
	}
	
	private Date getMonthBefore() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}
	
	private void addToGroupedLeaders(
		Map<String, LeaderboardEntryDto> map,
		PointsTransferInfo info
	) {
		String key = info.toUser;
		if (map.get(key) == null)
			map.put(key, new LeaderboardEntryDto(key, info.points));
		else
			map.get(key).points += info.points;
	}
	
	private ArrayList<LeaderboardEntryDto> getTopFive(Collection<LeaderboardEntryDto> collection) {
		ArrayList<LeaderboardEntryDto> entries = new ArrayList<>(collection);
		entries.sort(new LeadersComparator());
		
		return getSublistOfFive(entries);
	}
	
	/**
	 * Compares by points Z->A, if equal by name A->Z.
	 * 
	 */
	private class LeadersComparator implements Comparator<LeaderboardEntryDto> {

		@Override
		public int compare(LeaderboardEntryDto o1, LeaderboardEntryDto o2) {
			long points1 = o1.points;
			long points2 = o2.points;
			
			if (points1 == points2)
    			return o1.name.compareTo(o2.name);
    		else if (points1 < points2)
    			return 1;
    		else
    			return -1;
		}
	}
	
	private ArrayList<LeaderboardEntryDto> getSublistOfFive(ArrayList<LeaderboardEntryDto> entries) {
		return new ArrayList<>(entries.subList(0, 5 > entries.size() ? entries.size() : 5));
	}

}
