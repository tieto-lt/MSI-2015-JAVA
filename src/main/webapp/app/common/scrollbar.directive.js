(function () {
  'use strict';

  angular
    .module('app.common')
    .directive('scrollbar', scrollbar)
    
    		
	function scrollbar() {
      
	  return {
		link: link
	  };
	  
	  function link(scope, element, attrs) {
		  element.mCustomScrollbar({
			  theme: 'rounded-dark',
			  mouseWheel:{ 
				  scrollAmount: 400,
				  preventDefault: true
			  },
			  callbacks:{
				    onTotalScroll:function(){
				    	if (attrs.whenScrolled) {
				    		scope.$apply(attrs.whenScrolled);
				    	}					    
				    },
				    onTotalScrollOffset: 500
				},
				scrollButtons:{ enable: true }
		  });
	  }
    }
})();