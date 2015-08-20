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
				  scrollAmount: 500,
				  preventDefault: true
			  },
			  callbacks:{
				    onTotalScroll:function(){
				    	if (attrs.whenScrolled) {
				    		scope.$apply(attrs.whenScrolled);
				    	}					    
				    },
				    onTotalScrollOffset: 300
				},
				scrollButtons:{ enable: true }
		  });
	  }
    }
})();