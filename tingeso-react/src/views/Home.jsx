import styles from "../styles/StylesHome.module.css";
import "../styles/StylesHome.css";

function Home() {
  return (
    <>
      <main className={styles.main}>
        <h1 className={styles.title}>¡BIENVENIDO!</h1>
        <p className={styles.text}>Inicia sesión para comenzar</p>
        <button type="button" className="color">
          Iniciar Sesión
        </button>
      </main>
    </>
  );
}

export default Home;
