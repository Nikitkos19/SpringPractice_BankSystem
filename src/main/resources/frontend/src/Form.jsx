import { useRef } from "react";
import './styles/Form.scss';
import Input from "./Input.jsx";

async function sendForm(e, ref){
    e.preventDefault();

    let formData = new FormData(ref.current);
    let response = await fetch('/', {
        method: 'POST',
        body: formData,
    })

    let result = await response.text();

    console.log(result);
    console.log(Array.from(formData.values()));

}

function Form(){

    let ref = useRef();

    return (
        <form className="form" action="/" ref={ref} onSubmit={(e) => sendForm(e, ref)}>

            <h1>Регистрация</h1>
            <div className="inputs">
                <Input name="name" placeholder="Введите имя"/>
                <Input name="surname" placeholder="Введите фамилию"/>
                <Input type="email" name="email" placeholder="Введите адрес электронной почты"/>
            </div>    
            
            <input type="submit" className="register" value='Зарегистрироваться'/>
        </form>
    )
}

export default Form;