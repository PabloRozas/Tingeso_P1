import "../styles/StylesDashboard.css";

function Dashboard() {
  return (
    <>
      <nav className="menu">
        <div className="containerMenus">
          <h2>Inicio</h2>
          <ul>
            <li>
              <a>Reporte Valores</a>
            </li>
            <li>
              <a>Monto Rep. vs Veh.</a>
            </li>
            <li>
              <a>Reporte Tiempos</a>
            </li>
            <li>
              <a>Monto Rep. vs TVeh.</a>
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
}

export default Dashboard;
