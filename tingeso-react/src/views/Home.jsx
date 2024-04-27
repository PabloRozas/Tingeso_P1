import "../styles/StylesHome.css";

function Home() {
  const handleClick = () => {
    // enrutamiento hacia el dashboard
    window.location.href = "/dashboard";
  };

  return (
    <>
      <main className="main" style={{ backgroundColor: "white" }}>
        <h1 className="title">¡BIENVENIDO!</h1>
        <p className="text">
          Dale al botón entrar para poder visualizar los reportes y el resumen
          de AutoFix
        </p>
        <button type="button" className="color" onClick={handleClick}>
          Entrar
        </button>
      </main>
    </>
  );
}

export default Home;
