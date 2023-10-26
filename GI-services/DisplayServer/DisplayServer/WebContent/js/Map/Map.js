
// making the map
var map = L.map('map').setView([ -18.766947, 46.869107], 6.2);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', 
{
    maxZoom: 10000000,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
})
.addTo(map);

var array_lglt =[];
var polygon =L.polygon(array_lglt).addTo(map);;

function addCoordinate(coupleLtLg) 
{
    array_lglt.push([coupleLtLg.lat ,coupleLtLg.lng]);
    L.marker([coupleLtLg.lat ,coupleLtLg.lng]).addTo(map) ;
    drawPolygon();
    duplicateLongitudeLatitude(coupleLtLg.lat, coupleLtLg.lng);
}

function drawPolygon() 
{
    map.removeLayer(polygon);
    polygon= L.polygon(array_lglt); 
    polygon.addTo(map);
}


function duplicateLongitudeLatitude(latitude ,longitude) 
{
    const container = document.querySelector(".dash-address-manipulation");
    addFieldset(container ,latitude,longitude);
}

function onMapClick(e) 
{
    addCoordinate(e.latlng);
}

map.on('click', onMapClick);




// INPUT 

const addButton = document.getElementById("additems");
const deleteButton = document.getElementById("deleteitems");
const container = document.querySelector(".dash-address-manipulation");
const refreshButton = document.getElementById("refreshitems");

addButton.addEventListener("click", function (event) 
{
  event.preventDefault();
  addFieldset(container);
});

deleteButton.addEventListener("click", function (event) 
{
  event.preventDefault();
  removeLastFieldset(container);
});

refreshButton.addEventListener("click", function (event) 
{

    event.preventDefault();
    const fieldsets = container.querySelectorAll(".gl-inline");
    while (fieldsets.length > 1) 
    {
      container.removeChild(fieldsets[fieldsets.length - 1]);
    }    

})

function createFieldset(latitude ,longitude) 
{
  const fieldset = document.createElement("div");
  fieldset.className = "gl-inline";
  fieldset.innerHTML = `
    <div class="u-s-m-b-30">
      <label class="gl-label" for="latitude">Latitude *</label>
      <input name="latitude[]" class="input-text input-text--primary-style" type="text" id="latitude" placeholder="Latitude" value="`+latitude+`" >
    </div>
    <div class="u-s-m-b-30">
      <label class="gl-label" for "longitude">Longitude *</label>
      <input name="longitude[]" class="input-text input-text--primary-style" type="text" id="longitude" placeholder="Longitude" value="`+longitude+`">
    </div>
  `;

  return fieldset;
}

function addFieldset(container ,latitude ,longitude) 
{
  const newFieldset = createFieldset(latitude ,longitude);
  const lastFieldset = container.lastElementChild;
  container.insertBefore(newFieldset, lastFieldset);
}

function removeLastFieldset(container) {
  const fieldsets = container.querySelectorAll(".gl-inline");
  if (fieldsets.length >= 1) {
    container.removeChild(fieldsets[fieldsets.length - 1]);
  }
}

  
// function (params) {
    
// }