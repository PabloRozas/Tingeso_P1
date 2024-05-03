import "../styles/StylesDashboard.css";
import { useState } from "react";
import LogoHist from "../icons/grafico-histograma.png";
import LogoMan from "../icons/volante.png";
import LogoMot from "../icons/motor.png";
import LogoHome from "../icons/chimenea-de-la-casa.png";

// Componentes
import { DHome } from "../components/DHome";
import { DReporte1 } from "../components/DReport1";
import { DReporte2 } from "../components/DReport2";
import { DReporte3 } from "../components/DReport3";
import { DReporte4 } from "../components/DReport4";
import { DFormVehicle } from "../components/DFormVehicle";
import { DFormReparation } from "../components/DFormReparation";
import { DReparations } from "../components/DReparations";

import PropTypes from "prop-types";

function ItemMenu({ opcion }) {
  // Si la opción es 1, entonces se muestra el componente DHome
  if (opcion == 1) {
    return <DHome />;
  }
  // Si la opción es 2, entonces se muestra el componente DReporte1
  if (opcion == 2) {
    return <DReporte1 />;
  }
  // Si la opción es 3, entonces se muestra el componente DReporte2
  if (opcion == 3) {
    return <DReporte2 />;
  }
  // Si la opción es 4, entonces se muestra el componente DReporte3
  if (opcion == 4) {
    return <DReporte3 />;
  }
  // Si la opción es 5, entonces se muestra el componente DReporte4
  if (opcion == 5) {
    return <DReporte4 />;
  }
  // Si la opción es 6, entonces se muestra el componente DFormReport
  if (opcion == 6) {
    return <DFormReparation />;
  }
  // Si la opción es 7, entonces se muestra el componente DFormVehicle
  if (opcion == 7) {
    return <DFormVehicle />;
  }
  // Si la opción es 8, entonces se muestra el componente DFormVehicle
  if (opcion == 8) {
    return <DReparations />;
  }
}

ItemMenu.propTypes = {
  opcion: PropTypes.number.isRequired,
};

function Dashboard() {
  const [opcion, setOpcion] = useState(1);

  const handleClick = (e) => {
    setOpcion(e);
  };
  return (
    <>
      <aside className="menu">
        <div className="containerMenus">
          <h2 onClick={() => handleClick(1)}>AutoFix</h2>
          <ul>
            <li onClick={() => handleClick(1)}>
              <img src={LogoHome} alt="hist" />
              <a>Inicio</a>
            </li>
            <li onClick={() => handleClick(7)}>
              <img src={LogoMan} alt="manurio" />
              <a>Registrar un Vehículo</a>
            </li>
            <li onClick={() => handleClick(6)}>
              <img src={LogoMot} alt="motor" />
              <a>Registrar una Rep.</a>
            </li>
            <li onClick={() => handleClick(8)}>
              <img src={LogoMot} alt="motor" />
              <a>Reparaciones</a>
            </li>
            <li onClick={() => handleClick(2)}>
              <img src={LogoHist} alt="hist" />
              <a>Reporte Valores</a>
            </li>
            {/* si se da click en el, se cambia el color a violeta */}
            <li onClick={() => handleClick(3)}>
              <img src={LogoHist} alt="hist" />
              <a>Monto Rep. vs Veh.</a>
            </li>
            <li onClick={() => handleClick(4)}>
              <img src={LogoHist} alt="hist" />
              <a>Reporte Tiempos</a>
            </li>
            <li onClick={() => handleClick(5)}>
              <img src={LogoHist} alt="hist" />
              <a>Monto Rep. vs TVeh.</a>
            </li>
          </ul>
        </div>
      </aside>
      {/* Aqui debe cambiar el componente */}
      <ItemMenu opcion={opcion} />
    </>
  );
}

export default Dashboard;
