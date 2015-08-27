package lt.msi2015.statistics;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.category.Category;
import lt.msi2015.pointsTransferInfo.PointsTransferInfo;
import lt.msi2015.pointsTransferInfo.PointsTransferInfoRepository;
import lt.msi2015.purchase.PurchaseInfo;
import lt.msi2015.purchase.PurchaseInfoRepository;
import lt.msi2015.shop.ShopRepository;
import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;

@Service
public class StatisticsService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PointsTransferInfoRepository transferRepo;
	
	@Autowired
	PurchaseInfoRepository purchaseRepo;
	
	@Autowired
	ShopRepository shopRepo;
	
	public StatisticsDto getStatistics() {
		StatisticsDto stats =new StatisticsDto();
		
		stats.setRegisteredUsersNumber(getRegisteredUsersNumber());
		stats.setTotalKarmaPointsSent(getTotalKarmaSent());
		stats.setPointsSentThisMonth(getTotalKarmaSentThisMonth());
		stats.setTotalTransfers(getTotalTransfers().longValue());
		stats.setTotalItemsGiven(getTotalItemsGiven().longValue());
		stats.setPointsToSend(getPointsToSend());
		stats.setMostPopularCategory(getMostPopularCategory());
		stats.setMostPopularItem(getMostPopularItem());
		stats.setMostTransfersByOnePerson(getMostTransfersFromUser());
		
		return stats;
	}
	
	public UserStatisticsDto getUserStatistics(Long id) {
		UserStatisticsDto stats =new UserStatisticsDto();
		
		stats.setItemsGotten(getUserItemsGotten(id));
		stats.setTransfersMade(getUserTransfersMade(id));
		stats.setTransfersGotten(getUserTransfersGotten(id));
		stats.setPointsSent(getUserPointsSent(id));
		stats.setPointsGotten(getUserPointsGotten(id));
		setAchievements(stats,id);
		
		
		return stats;
	}
	
	/*
	 * * * * * * * private methods * * * * * * * 	
	 */
	
	private void setAchievements(UserStatisticsDto stats, Long id) {
		User user = userRepo.findById(id);
		stats.setAchievement_1(user.getAchievement_1());
		stats.setAchievement_2(user.getAchievement_2());
		stats.setAchievement_3(user.getAchievement_3());
		
	}

	private Date getMonthBefore() {  //for monthly statistics
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
	}
	
	
	private Integer getRegisteredUsersNumber() {
		List <User> userList = userRepo.findAll();
		return userList.size();
	}
	
	private Integer getTotalTransfers() {
		List<PointsTransferInfo> allTransfers = transferRepo.findAll();
		return allTransfers.size();
	}
	
	private Integer getTotalItemsGiven(){
		List<PurchaseInfo> allPurchases = purchaseRepo.findAll();
		return allPurchases.size();
	}
	
	private Long getTotalKarmaSent() {
		long totalPoints = 0;
	
		List<PointsTransferInfo> allTransfers = transferRepo.findAll();
		
		for(PointsTransferInfo transfer : allTransfers ){
			totalPoints += transfer.points;
		}
		
		return new Long(totalPoints);
	}
		
	private Long getTotalKarmaSentThisMonth() {
		long totalPoints = 0;
	
		List<PointsTransferInfo> allTransfers = transferRepo.findAll();
		
		for(PointsTransferInfo transfer : allTransfers ){
			if (transfer.dateCreated.after(getMonthBefore())){
				totalPoints += transfer.points;		
			}

		}
		
		return new Long(totalPoints);
	}
	
	private Long getPointsToSend() {
		long toSend = 0;
	
		List <User> userList = userRepo.findAll();
		
		for(User user : userList ){
			toSend += user.getPointsToGive(); 
		}
		
		return new Long(toSend);
	}
	
	private String getMostPopularCategory(){
		
		Map<Category, Integer> map = new HashMap<>();
		
		List<PointsTransferInfo> allTransfers = transferRepo.findAll();
		
		for(PointsTransferInfo transfer : allTransfers ){
			
			if(map.containsKey(transfer.category)){
				map.replace(transfer.category, map.get(transfer.category) + 1);
			} else {
				map.put(transfer.category, 1);
			}
			
		}
		
		Category mostPopularCategory = null;
		Integer max = 0;
		
		for(Map.Entry<Category, Integer> entry : map.entrySet()){
		    if (mostPopularCategory == null || entry.getValue() > max)
		    {
		    	mostPopularCategory = entry.getKey();
		    	max = entry.getValue();
		    }
		}
		
		return mostPopularCategory.getName();
	}
	
	private String getMostPopularItem(){
		
		Map<Long, Integer> map = new HashMap<>();
		
		List<PurchaseInfo> allPurchases = purchaseRepo.findAll();
		
		for(PurchaseInfo purchase : allPurchases ){
			
			if(map.containsKey(purchase.getShopItemId())){
				map.replace(purchase.getShopItemId(), map.get(purchase.getShopItemId()) + 1);
			} else {
				map.put(purchase.getShopItemId(), 1);
			}
			
		}
		
		Long mostPopularItemId = null;
		Integer max = 0;
		
		for(Map.Entry<Long, Integer> entry : map.entrySet()){
		    if (mostPopularItemId == null || entry.getValue() > max)
		    {
		    	mostPopularItemId = entry.getKey();
		    	max = entry.getValue(); 
		    }
		}
		
		if(mostPopularItemId != null){
			return shopRepo.findById(mostPopularItemId).getName();
		} else {
			return "Nothing!";
		}
		
	}
	
	private Integer getMostTransfersFromUser() {
		Map<Long, Integer> map = new HashMap<>();
		
		List<PointsTransferInfo> allTransfers = transferRepo.findAll();
		
		for(PointsTransferInfo transfer : allTransfers ){
			
			if(map.containsKey(transfer.getFromUserID())){
				map.replace(transfer.getFromUserID(), map.get(transfer.getFromUserID()) + 1);
			} else {
				map.put(transfer.getFromUserID(), 1);
			}
			
		}
		
		return Collections.max(map.values());
	}
	
	private Integer getUserItemsGotten(Long id){
		return purchaseRepo.findAllByUserId(id).size();
	}
	
	private Integer getUserTransfersMade(Long id){
		return transferRepo.findByFromUserID(id).size();
	}
	
	private Integer getUserTransfersGotten(Long id){
		return transferRepo.findByToUserID(id).size();
	}
	
	private Integer getUserPointsSent(Long id){
		int total = 0;
		for(PointsTransferInfo transfer : transferRepo.findByFromUserID(id)){
			total += transfer.getPoints();
		}
		return total;
	}
	
	private Integer getUserPointsGotten(Long id){
		int total = 0;
		for(PointsTransferInfo transfer : transferRepo.findByToUserID(id)){
			total += transfer.getPoints();
		}
		return total;
	}
	
}
