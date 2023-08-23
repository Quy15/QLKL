import { Link } from "react-router-dom";
import heroImg from "../assets/why-us.png"
const Main = () => {
    return <>
        <section id="hero" class="d-flex align-items-center">

            <div class="container">
            <div class="row">
                <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
                <h1>Quản Lý Khóa Luận Tốt Nghiệp</h1>
                <h2></h2>
                <div class="d-flex justify-content-center justify-content-lg-start">
                    <Link to="../Login" class="btn-get-started">Get Started</Link>
                </div>
                </div>
                <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="200">
                <img src={heroImg} class="img-fluid animated" alt=""/>
                </div>
            </div>
            </div>

        </section>
    </>
}

export default Main;