import "../styles/StylesForms.css";
import axios from "axios";
import { useEffect, useState } from "react";

export function DFormVehicle() {
  const [vehicleTypes, setVehicleTypes] = useState([]);
  const [engineTypes, setEngineTypes] = useState([]);
  const [brands, setBrands] = useState([]);
  const [patent, setPatent] = useState("");
  const [model, setModel] = useState("");
  const [year_production, setYear_production] = useState("");
  const [number_seats, setNumber_seats] = useState("");
  const [id_engine_type, setId_engine_type] = useState("");
  const [id_brand, setId_brand] = useState("");
  const [id_vehicle_type, setId_vehicle_type] = useState("");

  // año actual
  const year = new Date().getFullYear();

  const handleSubmit = async (event) => {
    event.preventDefault(); // Evita que la página se recargue al enviar el formulario
    axios
      .post("http://localhost:8080/vehicle/create", {
        patent: patent,
        model: model,
        year_production: year_production,
        number_seats: number_seats,
        id_engine_type: id_engine_type,
        id_brand: id_brand,
        id_vehicle_type: id_vehicle_type,
      })
      .then((response) => {
        console.log("Vehículo registrado:", response.data);
      })
      .catch((error) => {
        console.error("Error al registrar el vehículo:", error);
      });
  };

  // se pide al momento de cargar un componente que se haga un llamado a la api para obtener los tipos de vehiculos y marcas
  useEffect(() => {
    async function fetchData() {
      try {
        const responseVehicleTypes = await axios.get(
          "http://localhost:8080/vehicleType/all"
        );
        console.log("Tipos de vehículos:", responseVehicleTypes.data);
        setVehicleTypes(responseVehicleTypes.data);

        const responseEngineType = await axios.get(
          "http://localhost:8080/engineType/all"
        );
        console.log("Tipos de motor:", responseEngineType.data);
        setEngineTypes(responseEngineType.data);

        const responseBrand = await axios.get(
          "http://localhost:8080/brands/all"
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
          <label htmlFor="patente">Patente:</label>
          <input
            type="text"
            id="patente"
            name="patente"
            onInput={(e) => setPatent(e.target.value)}
            required
          />

          <label htmlFor="modelo">Modelo:</label>
          <input
            type="text"
            id="modelo"
            name="modelo"
            onInput={(e) => setModel(e.target.value)}
            required
          />

          <label htmlFor="anio">Año de Producción:</label>
          <input
            type="number"
            id="anio"
            name="anio"
            max={year}
            min={year - 12}
            defaultValue={year}
            onInput={(e) => setYear_production(e.target.value)}
            required
          />

          <label htmlFor="asientos">Cantidad de Asientos:</label>
          <input
            type="number"
            id="asientos"
            name="asientos"
            min="2"
            max="12"
            defaultValue="4"
            onInput={(e) => setNumber_seats(e.target.value)}
            required
          />

          <label htmlFor="motor">Tipo de Motor:</label>
          <select
            id="motor"
            name="motor"
            onInput={(e) => setId_engine_type(e.target.value)}
            required
          >
            {engineTypes.map((brand, index) => (
              <option key={index} value={brand.id}>
                {brand.name}
              </option>
            ))}
          </select>

          <label htmlFor="marca">Marca:</label>
          <select
            id="marca"
            name="marca"
            onInput={(e) => setId_brand(e.target.value)}
            required
          >
            {brands.map((brand, index) => (
              <option key={index} value={brand.id}>
                {brand.name}
              </option>
            ))}
          </select>

          <label htmlFor="tipo">Tipo de Vehículo:</label>
          <select
            id="tipo"
            name="tipo"
            onInput={(e) => setId_vehicle_type(e.target.value)}
            required
          >
            {vehicleTypes.map((vehicleType, index) => (
              <option key={index} value={vehicleType.id}>
                {vehicleType.name}
              </option>
            ))}
          </select>
        </form>

        <button type="submit" className="buttonSumbit" onClick={handleSubmit}>
          Registrar Vehículo
        </button>
      </div>
    </main>
  );
}
