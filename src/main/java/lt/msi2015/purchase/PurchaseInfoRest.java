package lt.msi2015.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseInfoRest {
	
	@Autowired
	PurchaseInfoService purchaseService;

	@RequestMapping(value = "/api/buy", method = RequestMethod.POST)
	ResponseEntity<?> buyItem(@RequestBody PurchaseInfoDto info) {
		if (purchaseService.buy(info)) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/api/togglepurchase/{id}", method = RequestMethod.POST)
	ResponseEntity<?> togglePurchase(@PathVariable Long id) {
		if(purchaseService.togglePurchase(id)){
			return new ResponseEntity<>(null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}	
	}
}
