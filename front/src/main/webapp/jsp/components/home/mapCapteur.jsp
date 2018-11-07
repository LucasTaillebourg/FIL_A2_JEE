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
		<div id="map" class="map"></div>
		    <div id="popup" class="ol-popup">
      <a href="#" id="popup-closer" class="ol-popup-closer"></a>
      <div id="popup-content"></div>
    </div>
	</div>
	
	<script src="https://cdn.rawgit.com/openlayers/openlayers.github.io/master/en/v5.3.0/build/ol.js"></script>
<link rel="stylesheet" href="https://cdn.rawgit.com/openlayers/openlayers.github.io/master/en/v5.3.0/css/ol.css">

<script>
var sensors = ${sensors};
	var layer = new ol.layer.Tile({
        source: new ol.source.OSM()
    });
	var vectorSource = new ol.source.Vector();

	    var vectorLayer = new ol.layer.Vector({
		      source: vectorSource
		     });

	    
	    
		sensors.forEach(function(sensor) {
			addMarker(sensor.lon, sensor.lat, 'Capteur ' + sensor.id);
		});

	       // create the map
        var map = new ol.Map({
            layers: [
              new ol.layer.Tile({
                  source: new ol.source.OSM()
              }),
              vectorLayer
            ],
            target: 'map',
            view: new ol.View({
                center: [0, 0],
                zoom: 2
            })
        });



        map.getView().fit(vectorSource.getExtent(), map.getSize());
		

		 function addMarker(lon, lat, libelle) {
			    console.log(lat);
			    console.log(lon);

			   
			    var iconFeature = new ol.Feature({
			      geometry: new ol.geom.Point(ol.proj.transform([lon, lat], 'EPSG:4326',
			        'EPSG:3857')),
			      name: libelle,
			      population: 4000,
			      rainfall: 500
			    });

			    iconFeature.setStyle(
			    		  new ol.style.Style({
			    		    image: new ol.style.Circle({
			    		        fill: new ol.style.Fill({ color: [255,0,0,1] }),
			    		        stroke: new ol.style.Stroke({ color: [0,0,0,1] }),
			    		        radius: 5
			    		    })
			    		  })
			    		);

			    

			    vectorSource.addFeature(iconFeature);


	   

			  }


    </script>
</body>
</html>
