import { useEffect, useState } from "react";
import "../styles/StylesReport2.css";
import axios from "axios";

export function DReport2_2(idVehicleType) {
  const [reports, setReports] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        console.log("idVehicleType:", idVehicleType.idVehicleType);
        const responseReport = await axios.get(
          "http://localhost:8090/repairType/report2/" +
            idVehicleType.idVehicleType
        );
        setReports(responseReport.data);
        console.log("Vouchers encontrados:", responseReport.data);
      } catch (error) {
        console.error("Error al buscar los vehículos o vouchers:", error);
      }
    }
    fetchData();
  }, [idVehicleType]);

  return (
    <section className="tableReport2">
      <table className="tableR2">
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
  );
}
