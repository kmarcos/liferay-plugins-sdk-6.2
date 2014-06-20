<%@include file="/html/hobbies/init.jsp" %>

<div id="myCarousel">
  <div class="carousel-item" style="background: url(http://alloyui.com/carousel/img/1.jpg); width: 700px; height: 250px;"></div>
  <div class="carousel-item" style="background: url(http://alloyui.com/carousel/img/2.jpg); width: 700px; height: 250px;"></div>
  <div class="carousel-item" style="background: url(http://alloyui.com/carousel/img/3.jpg); width: 700px; height: 250px;"></div>
  <div class="carousel-item" style="background: url(http://alloyui.com/carousel/img/4.jpg); width: 700px; height: 250px;"></div>
</div>

<aui:script use="aui-carousel">
var carousel = new A.Carousel(
  {
    activeIndex: 'rand',
    contentBox: '#myCarousel',
    height: 250,
    width: 700
   }
).render();
</aui:script>