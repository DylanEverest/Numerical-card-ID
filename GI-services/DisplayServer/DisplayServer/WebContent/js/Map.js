// making the map
var map = L.map('map').setView([ -18.766947, 46.869107], 6.2);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', 
{
    maxZoom: 10000000,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
})
.addTo(map);

var array_lglt =[];

function addCoordinate(coupleLtLg) 
{
    array_lglt.push([coupleLtLg.lat ,coupleLtLg.lng]);
    L.marker([coupleLtLg.lat ,coupleLtLg.lng]).addTo(map) ;
    drawPolygon();
}

function drawPolygon() 
{
    L.polygon(array_lglt).addTo(map); 
}


function onMapClick(e) 
{
    addCoordinate(e.latlng);
}

map.on('click', onMapClick);
