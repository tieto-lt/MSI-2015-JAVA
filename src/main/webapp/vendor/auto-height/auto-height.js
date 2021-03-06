/**
 * @version 0.0.4
 * @copyright TWY GmbH [All Rights Reserved]
 * @license MIT License (see LICENSE.txt)
 */
angular.module('twygmbh.auto-height', []).directive('autoHeight', [
    '$window', '$timeout', function($window, $timeout) {
        return {
            link: function($scope, $element, $attrs) {
                var combineHeights, siblings;
                combineHeights = function(collection) {
                    var heights, i, len, node;
                    heights = 0;
                    for (i = 0, len = collection.length; i < len; i++) {
                        node = collection[i];
                        heights += node.offsetHeight;
                    }
                    return heights;
                };
                siblings = function($elm) {
                    var elm, i, len, ref, results;
                    ref = $elm.parent().children();
                    results = [];
                    for (i = 0, len = ref.length; i < len; i++) {
                        elm = ref[i];
                        if (elm !== $elm[0]) {
                            results.push(elm);
                        }
                    }
                    return results;
                };
                angular.element($window).bind('resize', function() {
                    var additionalHeight, parentHeight;
                    additionalHeight = $attrs.additionalHeight || 0;
                    parentHeight = $window.innerHeight - $element.parent()[0].getBoundingClientRect().top;
                    return $element.css('height', (parentHeight - combineHeights(siblings($element)) - additionalHeight) + "px");
                });
                return $timeout(function() {
                    return angular.element($window).triggerHandler('resize');
                }, 1000);
            }
        };
    }
]);

// ---
// generated by coffee-script 1.9.2