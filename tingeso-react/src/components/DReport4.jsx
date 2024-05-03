import axios from "axios";
import "../styles/StylesReport4.css";
import { useEffect, useState } from "react";

export function DReporte4() {
  const [engineTypes, setEngineTypes] = useState([]);
  const [reports, setReports] = useState([]);
  const [idEngineType, setIdEngineType] = useState("1");

  const handleSelectChange = (event) => {
    setIdEngineType(event.target.value);
  };

  useEffect(() => {
    async function fetchData() {
      try {
        const responseEngineTypes = await axios.get(
          "http://localhost:8090/engineType/all"
        );
        setEngineTypes(responseEngineTypes.data);
        console.log("Motores encontrados:", responseEngineTypes.data);

        const responseReport = await axios.get(
          "http://localhost:8090/repairType/report4/" + idEngineType
        );
        console.log("Reporte encontrado:", responseReport.data);
        setReports(responseReport.data);
      } catch (error) {
        console.error("Error al buscar los motores:", error);
      }
    }
    fetchData();
  }, [idEngineType]);

  return (
    <main>
      <h1>Reporte de Monto Reparaciones vs. Tipo de Vehículo</h1>
      {/* tipo de motor */}
      <section className="selectEngineType">
        <label>Tipo de Motor:</label>
        <select
          id="idEngineType"
          name="idEngineType"
          onChange={handleSelectChange}
        >
          {engineTypes.map((engineType) => (
            <option key={engineType.id} value={engineType.id}>
              {engineType.name}
            </option>
          ))}
        </select>
      </section>

      <section className="tableReport4">
        <table className="tableR4">
          <thead>
            <tr>
              <th style={{ borderTopLeftRadius: "7px" }}>Nombre Reparación</th>
              <th>Total Reparaciones</th>
              <th style={{ borderTopRightRadius: "7px" }}>Total Recaudado</th>
            </tr>
          </thead>
          <tbody>
            {reports.map((report, index) => (
              <tr key={index}>
                <td style={{ textAlign: "left", paddingLeft: "30px" }}>
                  {report.name_type_repair}
                </td>
                <td>{report.total_reparations}</td>
                <td>{report.total_mount}</td>
              </tr>
            ))}
            {reports.length === 0 && (
              <tr>
                <td colSpan="3">No hay datos para mostrar</td>
              </tr>
            )}
          </tbody>
        </table>
      </section>
    </main>
  );
}
