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
import lt.msi2015.user.UserRepository;

@Service
public class LeaderboardService {
	
	@Autowired
	PointsTransferInfoRepository pointTransfers;
	
	@Autowired
	UserRepository userRepo;
	
	@Transactional
	public List<LeaderboardEntryDto> getLeaderboardSortedEntries() {

		Map<Long, LeaderboardEntryDto> groupedLeaders = new HashMap<>();
		
		for (PointsTransferInfo historyEntry : pointTransfers.findAll()) {
			if (historyEntry.dateCreated.after(getMonthBefore()))
				addToGroupedLeaders(groupedLeaders, historyEntry);			
		}
		
		return sortLeaders(groupedLeaders.values());
	}
	
	
	private Date getMonthBefore() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
	}
	
	
	
	private void addToGroupedLeaders(
		Map<Long, LeaderboardEntryDto> map,
		PointsTransferInfo info
	) {
		Long key = info.toUserID;
		if (map.get(key) == null)
			map.put(key, new LeaderboardEntryDto(key, userRepo.findById(key).getFirstName() + " " + userRepo.findById(key).getLastName(), info.points));
		else
			map.get(key).points += info.points;
	}
	
	
	
	private List<LeaderboardEntryDto> sortLeaders(Collection<LeaderboardEntryDto> collection) {
		
		List<LeaderboardEntryDto> entries = new ArrayList<>(collection);
		entries.sort(new LeadersComparator());
		
		return entries;
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
	
	
	
	public List<LeaderboardEntryDto> getSublistOfFive(List<LeaderboardEntryDto> entries) {
		return new ArrayList<>(entries.subList(0, 5 > entries.size() ? entries.size() : 5));
	}
	
	public Integer getUserRank(Long userId) {
		
		List <LeaderboardEntryDto> rankings = getLeaderboardSortedEntries();
		
		Integer rank = 1;
		for(LeaderboardEntryDto entry : rankings) {
			if(entry.getUserID() == userId) {
				return rank;
			} else {
				rank++;
			}
		}
		
		return rank;
	}

}
