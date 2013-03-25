	 /** 
	 * DEMO
	 * getHotel(map,local, new BMap.Point(x, y), 1000, "酒店");
	 * 关键字是数组
	 * getHotel(map,local, new BMap.Point(x, y), 1000, ["酒店", "餐馆"]);
	 */
	 /**
	 * 获取指定中心点，指定半径内的
	 * @param {Map} map地图实例 new BMap("");
	 * @param {LocalSearch} local查询实例 new BMap.LocalSearch()
	 * @param {Point} point 中心点对象 new BMap.Point(lng, lat);
	 * @param {int} raduis 半径范围
	 * @param {}
	 */
	 function getHotel(map, local, point, radius, keyword){
		 var bounds = getSquareBounds(map,point, radius);
		 local.searchInBounds(keyword,bounds); 
	 }
	  /**
     * 得到圆的内接正方形bounds
     * @param {Point} centerPoi 圆形范围的圆心
     * @param {Number} r 圆形范围的半径
     */ 
	 function getSquareBounds(map,centerPoi,r){
		var a = Math.sqrt(2) * r; 
	  
		mPoi = getMecator(map,centerPoi);
		var x0 = mPoi.x, y0 = mPoi.y;
		//东北点
		var x1 = x0 + a / 2 , y1 = y0 + a / 2;
		//西南点
		var x2 = x0 - a / 2 , y2 = y0 - a / 2;
		
		var ne = getPoi(map,new BMap.Pixel(x1, y1)), sw = getPoi(map,new BMap.Pixel(x2, y2));
		return new BMap.Bounds(sw, ne);        			
	}
    //根据球面坐标获得平面坐标。
    function getMecator(map,poi){
        return map.getMapType().getProjection().lngLatToPoint(poi);
    }
    //根据平面坐标获得球面坐标。
    function getPoi(map,mecator){
        return map.getMapType().getProjection().pointToLngLat(mecator);
    }