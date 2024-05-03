import "../styles/StylesReport2.css";
import axios from "axios";
import { useEffect, useState } from "react";
import { DReport2_2 } from "./DReport2_2";

export function DReporte2() {
  const [vehiclesTypes, setVehiclesTypes] = useState([]);
  const [idVehicleType, setIdVehicleType] = useState("1");

  const handleSelectChange = (event) => {
    setIdVehicleType(event.target.value);
  };

  useEffect(() => {
    async function fetchData() {
      try {
        const responseVehiclesTypes = await axios.get(
          "http://localhost:8090/vehicleType/all"
        );
        setVehiclesTypes(responseVehiclesTypes.data);
        console.log("Vehículos encontrados:", responseVehiclesTypes.data);
      } catch (error) {
        console.error("Error al buscar los vehículos o vouchers:", error);
      }
    }
    fetchData();
  }, []);

  return (
    <main>
      <h1>Monto total según tipo de Reparación y tipo de Vehículo</h1>
      {/* tipo de vehiculo */}
      <section className="selectVehicle">
        <label>Tipo de Vehículo:</label>
        <select
          id="idVehicleType"
          name="idVehicleType"
          onChange={handleSelectChange}
        >
          {vehiclesTypes.map((vehicleType) => (
            <option key={vehicleType.id} value={vehicleType.id}>
              {vehicleType.name}
            </option>
          ))}
        </select>
      </section>

      <DReport2_2 idVehicleType={idVehicleType} />
    </main>
  );
}
