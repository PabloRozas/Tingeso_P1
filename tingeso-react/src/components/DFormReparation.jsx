import { useEffect, useState } from "react";
import axios from "axios";
import "../styles/StylesForms.css";

export function DFormReparation() {
  const [vehicles, setVehicles] = useState([]);
  const [tipeReparation, setTipeReparation] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault(); // Evita que la página se recargue al enviar el formulario
    axios
      .post("http://localhost:8080/reparation/create", {
        date_admision: document.getElementById("dateAdmision").value,
        entry_time: document.getElementById("entryTime").value,
        repair_type: document.getElementById("repairType").value,
        departure_date: document.getElementById("departureDate").value,
        daparture_time: document.getElementById("departureTime").value,
        vehicle: document.getElementById("idVehicle").value,
      })
      .then((response) => {
        console.log("Reparación registrada:", response.data);
      })
      .catch((error) => {
        console.error("Error al registrar la reparación:", error);
      });
  };

  useEffect(() => {
    async function fetchData() {
      try {
        const responseVehicle = await axios.get(
          "http://localhost:8080/vehicle/all"
        );
        setVehicles(responseVehicle.data);

        const responseReparationType = await axios.get(
          "http://localhost:8080/repairType/all"
        );
        setTipeReparation(responseReparationType.data);
      } catch (error) {
        console.error("Error al obtener los vehículos:", error);
      }
    }
    fetchData();
  }, []);

  return (
    <main>
      <h1 className="titleReport">Registrar una Reparación</h1>
      <div className="containerForm">
        <form className="formPost">
          <label htmlFor="dateAdmision">Fecha de Admisión:</label>
          <input type="date" id="dateAdmision" name="dateAdmision" required />
          <label htmlFor="entryTime">Hora de Ingreso:</label>
          <input type="time" id="entryTime" name="entryTime" required />
          <label htmlFor="idReparationType">Tipo de Reparación:</label>
          <select id="idReparationType" name="idReparationType" required>
            {tipeReparation.map((reparation) => (
              <option key={reparation.id} value={reparation.id} id="repairType">
                {reparation.name}
              </option>
            ))}
          </select>
          <label htmlFor="departureDate">Fecha de Salida:</label>
          <input type="date" id="departureDate" name="departureDate" required />
          <label htmlFor="departureTime">Hora de Salida:</label>
          <input type="time" id="departureTime" name="departureTime" required />
          <label htmlFor="idVehicle">Vehículo:</label>
          <select id="idVehicle" name="idVehicle" required>
            {vehicles.map((vehicle) => (
              <option key={vehicle.id} value={vehicle.id} id="idVehicle">
                {vehicle.patent}
              </option>
            ))}
          </select>
        </form>

        <button type="submit" className="buttonSumbit" onClick={handleSubmit}>
          Registrar Reparación
        </button>
      </div>
    </main>
  );
}
