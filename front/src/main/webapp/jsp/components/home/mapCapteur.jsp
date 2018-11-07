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
	</div>
	
	<script src="https://cdn.rawgit.com/openlayers/openlayers.github.io/master/en/v5.3.0/build/ol.js"></script>
<link rel="stylesheet" href="https://cdn.rawgit.com/openlayers/openlayers.github.io/master/en/v5.3.0/css/ol.css">

<script>
var sensors = ${sensors};

var container = document.getElementById('popup');
var content = document.getElementById('popup-content');
var closer = document.getElementById('popup-closer');

/**
 * Create an overlay to anchor the popup to the map.
 */
var overlay = new ol.Overlay({
  element: container,
  autoPan: true,
  autoPanAnimation: {
    duration: 250
  }
});


/**
 * Add a click handler to hide the popup.
 * @return {boolean} Don't follow the href.
 */
closer.onclick = function() {
  overlay.setPosition(undefined);
  closer.blur();
  return false;
};

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
            }),
            overlays: [overlay]
        });

        /**
         * Add a click handler to the map to render the popup.
         */
        map.on('singleclick', function(evt) {
            var f = map.forEachFeatureAtPixel(
                    evt.pixel,
                    function(ft, layer){return ft;}
                );
                if (f && f.get('type') == 'click') {
                    var geometry = f.getGeometry();
                    var coord = geometry.getCoordinates();
                    
                 
                    
                    content.innerHTML = '<p>'+f.get('desc')+'</p>';
                overlay.setPosition(coord);
                    
                } else { overlay.setPosition(undefined); }
        });
        vectorLayer.setZIndex( 1001 ); 
        map.getView().fit(vectorSource.getExtent(), map.getSize());
		

		 function addMarker(lon, lat, libelle) {
			    console.log(lat);
			    console.log(lon);

			   
			    var iconFeature = new ol.Feature({
			      geometry: new ol.geom.Point(ol.proj.transform([lon, lat], 'EPSG:4326',
			        'EPSG:3857')),
			      desc: libelle,
			      type: 'click'
			    });

			    iconFeature.setStyle(
			    		  new ol.style.Style({
			    		    image: new ol.style.Icon({
			    		    	src: 'resources/img/icons/pin.png'
			    		    	
			    		    })
			    		  })
			    		);

			    

			    vectorSource.addFeature(iconFeature);
			    

	   

			  }


    </script>
</body>
</html>
