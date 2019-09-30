$( window ).load(function() {
var autoUpdate=true;
function updateIndex(){
if(autoUpdate){
var slide=$('.cmp-tabs__tab.cmp-tabs__tab--active');
var content=$('.cmp-tabs__tabpanel.cmp-tabs__tabpanel--active');
console.log(slide);
var nextSlider=slide.next();
var nextContent=content.next();
console.log(nextSlider);
slide.removeClass('cmp-tabs__tab--active');
content.removeClass('cmp-tabs__tabpanel--active');
console.log(nextSlider.length);
console.log(nextContent.length);
if(nextSlider.length==0 ){
console.log('here');
$('.cmp-tabs__tab').first().addClass('cmp-tabs__tab--active');
$('.cmp-tabs__tabpanel').first().addClass('cmp-tabs__tabpanel--active');

}
nextSlider.addClass('cmp-tabs__tab--active');
nextContent.addClass('cmp-tabs__tabpanel--active');
}
}
window.setInterval(updateIndex, 3000);
$('.cmp-tabs__tab').click(function(){
autoUpdate=false;
window.setTimeout(function(){autoUpdate=true;},7000);
      $(".cmp-tabs__tab").css({ "outline": "none"});
})
});
