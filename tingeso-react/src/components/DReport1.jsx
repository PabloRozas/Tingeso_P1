import "../styles/StylesReport1.css";
import axios from "axios";
import { useEffect, useState } from "react";

export function DReporte1() {
  const [reports, setReports] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const responseReport = await axios.get(
          "http://localhost:8090/voucher/report1"
        );
        setReports(responseReport.data);
        console.log("Vouchers encontrados:", responseReport.data);
      } catch (error) {
        console.error("Error al buscar los vehículos o vouchers:", error);
      }
    }
    fetchData();
  }, []);

  return (
    <main>
      <h1>Detalle de cálculos por vehículo</h1>
      {/* Tabla de vehiculos */}
      <section className="tableReport">
        <table className="tableR1">
          <thead>
            <tr>
              <th style={{ borderTopLeftRadius: "7px" }}>Patente</th>
              <th>ID Reparación</th>
              <th>Descuento 1</th>
              <th>Descuento 2</th>
              <th>Descuento 3</th>
              <th>Recargo 1</th>
              <th>Recargo 2</th>
              <th>Recargo 3</th>
              <th>Monto Reparaciones</th>
              <th style={{ borderTopRightRadius: "7px" }}>Monto Total*</th>
            </tr>
          </thead>
          <tbody>
            {reports.map((report) => (
              <tr key={report.id}>
                <td>{report.patent_vehicle}</td>
                <td>{report.id_reparation}</td>
                <td>{report.descount1}</td>
                <td>{report.descount2}</td>
                <td>{report.descount3}</td>
                <td>{report.surcharge1}</td>
                <td>{report.surcharge2}</td>
                <td>{report.surcharge3}</td>
                <td>{report.total_reparation}</td>
                <td>{report.mount}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </section>
      <p className="nota">
        * Si el monto del descuento 3 y el recargo 3 son vacíos, el monto total
        no refleja el monto total a pagar.
      </p>
    </main>
  );
}
