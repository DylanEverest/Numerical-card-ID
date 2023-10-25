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
    console.log(coupleLtLg);
    array_lglt.push(coupleLtLg);
    L.marker([coupleLtLg.lat ,coupleLtLg.lng]).addTo(map) ;
}

function drawPolygon() 
{

}

//     var marker = L.marker([51.5, -0.09]).addTo(map);

// var polygon = L.polygon([
//     [51.509, -0.08],
//     [51.503, -0.06],
//     [51.51, -0.047]
// ]).addTo(map);


function onMapClick(e) 
{
    addCoordinate(e.latlng);
}

map.on('click', onMapClick);
