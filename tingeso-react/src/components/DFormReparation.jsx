import { useEffect, useState } from "react";
import axios from "axios";
import "../styles/StylesForms.css";

export function DFormReparation() {
  const [vehicles, setVehicles] = useState([]);
  const [tipeReparation, setTipeReparation] = useState([]);
  const [reparationTypes, setReparationTypes] = useState([]);
  const [responseText, setResponseText] = useState("");

  const handleSelectChange = (event) => {
    const selectedOption = event.target.value;
    setReparationTypes((prevReparationTypes) => {
      if (prevReparationTypes.includes(selectedOption)) {
        return prevReparationTypes.filter(
          (reparationType) => reparationType !== selectedOption
        );
      } else {
        return [...prevReparationTypes, selectedOption];
      }
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault(); // Evita que la página se recargue al enviar el formulario

    try {
      // Crear la reparación
      const responseCreate = await axios.post(
        "http://localhost:8090/reparation/create",
        {
          date_admision: document.getElementById("dateAdmision").value,
          entry_time: document.getElementById("entryTime").value,
          departure_date: document.getElementById("departureDate").value,
          daparture_time: document.getElementById("departureTime").value,
          vehicle: document.getElementById("idVehicle").value,
        }
      );

      const idReparation = responseCreate.data.id;
      console.log("Reparación registrada:", idReparation);

      // Agregar los tipos de reparaciones
      for (let i = 0; i < reparationTypes.length; i++) {
        await axios.post("http://localhost:8090/reparation/addRepairType", {
          reparation: idReparation,
          repair_type: reparationTypes[i],
        });
        console.log("Tipo de reparación agregado:", reparationTypes[i]);
      }

      const responseMount = await axios.post(
        "http://localhost:8090/reparation/calculateVoucher",
        {
          reparation: idReparation,
        }
      );
      console.log("Voucher generado:", responseMount.data);

      setResponseText("Reparación registrada correctamente ✅");
    } catch (error) {
      console.error("Error al registrar la reparación:", error);
      setResponseText("Error al registrar la reparación ❌");
    }
  };

  useEffect(() => {
    async function fetchData() {
      try {
        const responseVehicle = await axios.get(
          "http://localhost:8090/vehicle/all"
        );
        setVehicles(responseVehicle.data);

        const responseReparationType = await axios.get(
          "http://localhost:8090/repairType/all"
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
        <form className="formPost" style={{ gridColumnGap: "0px" }}>
          <label htmlFor="dateAdmision">Fecha de Admisión:</label>
          <input type="date" id="dateAdmision" name="dateAdmision" required />
          <label htmlFor="entryTime">Hora de Ingreso:</label>
          <input type="time" id="entryTime" name="entryTime" required />
          {/* lista de seleccion multiple para los distintos tipos de repaciones */}
          <label htmlFor="idReparationType">Tipo de Reparación:</label>
          <div className="listContainerCheck">
            {tipeReparation.map((reparationType) => (
              <div key={reparationType.id}>
                <input
                  type="checkbox"
                  id={`reparationType-${reparationType.id}`}
                  name="reparationType"
                  value={reparationType.id}
                  onChange={handleSelectChange}
                  style={{ marginLeft: "10px" }}
                />
                <label
                  htmlFor={`reparationType-${reparationType.id}`}
                  style={{ marginLeft: "10px" }}
                >
                  {reparationType.name}
                </label>
              </div>
            ))}
          </div>
          <label htmlFor="departureDate">Fecha de Salida:</label>
          <input type="date" id="departureDate" name="departureDate" required />
          <label htmlFor="departureTime">Hora de Salida:</label>
          <input type="time" id="departureTime" name="departureTime" required />
          <label htmlFor="idVehicle">Automovil:</label>
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

        <div>
          <h3 className="responseText">{responseText}</h3>
        </div>
      </div>
    </main>
  );
}
