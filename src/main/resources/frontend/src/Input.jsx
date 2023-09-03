import { useState } from "react";

export default function Input(props){

    let [value, setValue] = useState('');

    return (
        <input type={props.type || 'text'} name={props.name} placeholder={props.placeholder || ''} maxLength={props.maxlength || 10}
        autoComplete="off" onInput={(e) => setValue(e.target.value)} value={value}/>
    )
}