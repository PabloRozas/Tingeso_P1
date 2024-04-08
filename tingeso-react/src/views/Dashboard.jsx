import "../styles/StylesDashboard.css";
import LogoHist from "../icons/grafico-histograma.png";
import LogoMan from "../icons/volante.png";
import LogoMot from "../icons/motor.png";

function Dashboard() {
  return (
    <>
      <aside className="menu">
        <div className="containerMenus">
          <h2>AutoFix</h2>
          <ul>
            <li>
              <img src={LogoMan} alt="manurio" />
              <a>Registrar un Vehículo</a>
            </li>
            <li>
              <img src={LogoMot} alt="motor" />
              <a>Registrar una Rep.</a>
            </li>
            <li>
              <img src={LogoHist} alt="hist" />
              <a>Reporte Valores</a>
            </li>
            <li>
              <img src={LogoHist} alt="hist" />
              <a>Monto Rep. vs Veh.</a>
            </li>
            <li>
              <img src={LogoHist} alt="hist" />
              <a>Reporte Tiempos</a>
            </li>
            <li>
              <img src={LogoHist} alt="hist" />
              <a>Monto Rep. vs TVeh.</a>
            </li>
          </ul>
        </div>
      </aside>
      {/* Aqui debe cambiar el componente */}
      <main>
        <h1>Bienvenidx al dashboard de AutoFix</h1>
        <p>Te preparamos un resumen</p>
      </main>
    </>
  );
}

export default Dashboard;
