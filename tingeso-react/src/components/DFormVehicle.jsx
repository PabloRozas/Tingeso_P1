import "../styles/StylesForms.css";
import axios from "axios";
import { useEffect, useState } from "react";

export function DFormVehicle() {
  const [vehicleTypes, setVehicleTypes] = useState([]);
  const [engineTypes, setEngineTypes] = useState([]);
  const [brands, setBrands] = useState([]);
  const [responseText, setResponseText] = useState("");

  // año actual
  const year = new Date().getFullYear();

  const handleSubmit = async (event) => {
    event.preventDefault(); // Evita que la página se recargue al enviar el formulario
    axios
      .post("http://localhost:8090/vehicle/create", {
        patent: document.getElementById("patent").value,
        model: document.getElementById("model").value,
        year_production: document.getElementById("year").value,
        number_seats: document.getElementById("seats").value,
        id_engine_type: document.getElementById("engineType").value,
        id_brand: document.getElementById("brand").value,
        id_vehicle_type: document.getElementById("vehicleType").value,
        km: document.getElementById("km").value,
      })
      .then((response) => {
        console.log("Vehículo registrado:", response.data);
        setResponseText("Vehículo registrado correctamente ✅");
      })
      .catch((error) => {
        console.error("Error al registrar el vehículo:", error);
        setResponseText("Error al registrar el vehículo ❌");
      });
  };

  // se pide al momento de cargar un componente que se haga un llamado a la api para obtener los tipos de vehiculos y marcas
  useEffect(() => {
    async function fetchData() {
      try {
        const responseVehicleTypes = await axios.get(
          "http://localhost:8090/vehicleType/all"
        );
        console.log("Tipos de vehículos:", responseVehicleTypes.data);
        setVehicleTypes(responseVehicleTypes.data);

        const responseEngineType = await axios.get(
          "http://localhost:8090/engineType/all"
        );
        console.log("Tipos de motor:", responseEngineType.data);
        setEngineTypes(responseEngineType.data);

        const responseBrand = await axios.get(
          "http://localhost:8090/brands/all"
        );
        console.log("Marcas de vehículos:", responseBrand.data);
        setBrands(responseBrand.data);
      } catch (error) {
        console.error("Error al obtener los datos:", error);
      }
    }

    fetchData();
  }, []);

  return (
    <main className="mainForm">
      <h1 className="titleVehicle">Registrar un Vehículo</h1>
      <div className="containerForm">
        {/* formulario para rellenar los datos de un vehiculo: patente, modelo, anio de produccion, numero de asientos, tipo de motor, marca y tipo de vehiculo */}
        <form className="formPost">
          <label htmlFor="patent">Patente:</label>
          <input type="text" id="patent" name="patent" required />

          <label htmlFor="model">Modelo:</label>
          <input type="text" id="model" name="model" required />

          <label htmlFor="year">Año de Producción:</label>
          <input
            type="number"
            id="year"
            name="year"
            max={year}
            min={year - 12}
            defaultValue={year}
            required
          />

          <label htmlFor="seats">Cantidad de Asientos:</label>
          <input
            type="number"
            id="seats"
            name="seats"
            min="2"
            max="12"
            defaultValue="4"
            required
          />

          <label htmlFor="engineType">Tipo de Motor:</label>
          <select id="engineType" name="engineType" required>
            {engineTypes.map((brand, index) => (
              <option key={index} value={brand.id}>
                {brand.name}
              </option>
            ))}
          </select>

          <label htmlFor="brand">Marca:</label>
          <select id="brand" name="brand" required>
            {brands.map((brand, index) => (
              <option key={index} value={brand.id}>
                {brand.name}
              </option>
            ))}
          </select>

          <label htmlFor="vehicleType">Tipo de Vehículo:</label>
          <select id="vehicleType" name="vehicleType" required>
            {vehicleTypes.map((vehicleType, index) => (
              <option key={index} value={vehicleType.id}>
                {vehicleType.name}
              </option>
            ))}
          </select>
          <label htmlFor="km">Kilometraje:</label>
          <input type="number" id="km" name="km" required />
        </form>

        <button type="submit" className="buttonSumbit" onClick={handleSubmit}>
          Registrar Vehículo
        </button>

        <div>
          <h3 className="responseText">{responseText}</h3>
        </div>
      </div>
    </main>
  );
}
