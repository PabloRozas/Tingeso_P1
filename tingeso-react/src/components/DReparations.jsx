import axios from "axios";
import { useEffect, useState } from "react";
import "../styles/StylesReparations.css";

export function DReparations() {
  const [reparations, setReparations] = useState([]);

  // metodo para pagar las reparacione
  const handleClick = (id) => {
    try {
      const response = axios.put(`http://localhost:8090/reparation/pay/${id}`);
      console.log("Reparación pagada:", response.data);
    } catch (error) {
      console.error("Error al pagar la reparación:", error);
    }
  };

  useEffect(() => {
    async function fetchData() {
      try {
        const responseReparation = await axios.get(
          "http://localhost:8090/reparation/all"
        );
        setReparations(responseReparation.data);
        console.log("Reparaciones encontradas:", responseReparation.data);
      } catch (error) {
        console.error("Error al buscar las reparaciones:", error);
      }
    }
    fetchData();
  }, []);

  return (
    <main>
      <h1>Reparaciones</h1>

      {/* Tabla de reparaciones */}
      <section className="tableReparation">
        <table className="tableRepairs">
          <thead>
            <tr>
              <th style={{ borderTopLeftRadius: "7px" }}>Id Reparación</th>
              <th>Patente Vehículo</th>
              <th>Fecha de Admisión</th>
              <th>Fecha de Entrega</th>
              <th>Costo Preliminar*</th>
              <th>Estado</th>
              <th style={{ borderTopRightRadius: "7px" }}>Pagar</th>
            </tr>
          </thead>
          <tbody>
            {reparations.map((reparation) => (
              <tr key={reparation.id}>
                <td>{reparation.id}</td>
                <td>{reparation.vehicle.patent}</td>
                <td>{reparation.date_admission}</td>
                <td>{reparation.departure_date}</td>
                <td>
                  {reparation.voucher && reparation.voucher.mount
                    ? reparation.voucher.mount
                    : "0"}
                </td>
                <td>
                  {reparation.retirement_time === ""
                    ? "No pagado ❌"
                    : "Pagado ✅"}
                </td>
                <td>
                  <button
                    className="pagarbtn"
                    onClick={handleClick.bind(this, reparation.id)}
                  >
                    Pagar
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </section>
      <p className="nota">
        * Para el costo preliminar solo se considera el cálculo sin recargos por
        atraso y sin descuento por bono
      </p>
    </main>
  );
}
