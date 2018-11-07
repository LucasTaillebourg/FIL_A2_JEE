<%--
  Created by IntelliJ IDEA.
  User: taillebourg
  Date: 28/10/18
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<div class="content-size">
		<div id="demoMap" style="height: 500px"></div>

	</div>
	<script src="http://www.openlayers.org/api/OpenLayers.js"></script>

	<script>
		var sensors = ${sensors};
		console.log(sensors);
		map = new OpenLayers.Map("demoMap");
		map.addLayer(new OpenLayers.Layer.OSM());
		sensors.forEach(function(sensor) {
			console.log(sensor);
			
		});
		var zoom = 16;

		var markers = new OpenLayers.Layer.Markers("Markers");
		
		sensors.forEach(function(sensor) {
			console.log(sensor);
			var lonLat = new OpenLayers.LonLat(sensor.lon, sensor.lat)
					.transform(new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
					map.getProjectionObject() // to Spherical Mercator Projection
					);
			markers.addMarker(new OpenLayers.Marker(lonLat));
			map.setCenter(lonLat,15);
		});
		map.addLayer(markers);
	</script>
	</div>
</body>
</html>
