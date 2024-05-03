import axios from "axios";
import { useEffect, useState } from "react";

export function DReporte3() {
  const [reports, setReports] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const responseReport = await axios.get(
          "http://localhost:8090/brands/report3"
        );
        setReports(responseReport.data);
        console.log("Reporte encontrado:", responseReport.data);
      } catch (error) {
        console.error("Error al buscar los vehículos:", error);
      }
    }
    fetchData();
  }, []);

  return (
    <main>
      <h1>Reporte de Tiempos promedios por Marcas</h1>
      <section className="tableReport">
        <table className="tableR1">
          <thead>
            <tr>
              <th style={{ borderTopLeftRadius: "7px" }}>Marca</th>
              <th style={{ borderTopRightRadius: "7px" }}>
                Tiempo promedio en días
              </th>
            </tr>
          </thead>
          <tbody>
            {reports.map((report) => (
              <tr key={report.id}>
                <td>{report.brand}</td>
                <td>{report.time_average}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </section>
    </main>
  );
}
