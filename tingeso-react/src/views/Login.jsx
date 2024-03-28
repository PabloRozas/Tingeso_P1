import "../styles/StylesLogin.css";

function Login() {
  return (
    <>
      <div className="container">
        <div className="containerForm">
          <h1 className="text-center">Iniciar Sesión</h1>
          <form>
            <div className="mb-3">
              <label htmlFor="exampleInputEmail1" className="form-label">
                Correo
              </label>
              <input
                type="email"
                className="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
              />
              <div id="emailHelp" className="form-text">
                Nunca compartiremos tu correo con nadie más.
              </div>
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputPassword1" className="form-label">
                Contraseña
              </label>
              <input
                type="password"
                className="form-control"
                id="exampleInputPassword1"
              />
            </div>
            <div className="mb-3 form-check">
              <input
                type="checkbox"
                className="form-check-input"
                id="exampleCheck1"
              />
              <label className="form-check-label" htmlFor="exampleCheck1">
                Recuérdame
              </label>
            </div>
            <button type="submit" className="btn btn-primary colorText">
              Enviar
            </button>
          </form>
        </div>
      </div>
    </>
  );
}
export default Login;
