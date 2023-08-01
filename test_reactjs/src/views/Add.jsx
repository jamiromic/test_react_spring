import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function Add() {
    const [marca, setMarca] = useState('');
  const [alimentazione, setAlimentazione] = useState('');
  const [colore, setColore] = useState('');
  const [annoImmatricolazione, setAnnoImmatricolazione] = useState('');
  const navigate = useNavigate();


    const handleFormSubmit = (event) => {
        event.preventDefault(); // Evita il comportamento di submit predefinito del browser
        const formData = {
            marca,
            alimentazione,
            colore,
            annoImmatricolazione,
          };
          console.log(formData);
        axios.post('http://localhost:8080/api/automobile/add', formData)
        .then((response) => {
          navigate("/");
        })
        .catch((error) => {
        console.error('Errore durante il salvataggio dei dati:', error);
        });
    };


  return (
    <div className='text-center' style={{ marginTop: '180px' }}>
        <form onSubmit={handleFormSubmit}>
            <label htmlFor="marca" style={{ width: '180px' }}>Marca</label>
            <input type="text" value={marca} onChange={(e) => setMarca(e.target.value)}/><br />
            <label htmlFor="alimentazione" style={{ width: '180px' }}>Alimentazione</label>
            <input type="text" value={alimentazione} onChange={(e) => setAlimentazione(e.target.value)}/><br />
            <label htmlFor="colore" style={{ width: '180px' }}>Colore</label>
            <input type="text" value={colore} onChange={(e) => setColore(e.target.value)}/><br />
            <label htmlFor="annoimmatricolazione" style={{ width: '180px', marginBottom: '20px' }}>Anno Immatricolazione</label>
            <input type="text" value={annoImmatricolazione} onChange={(e) => setAnnoImmatricolazione(e.target.value)}/><br />
            <button type="submit">Conferma</button>
            <Link to="/">Annulla</Link>
        </form>
    </div>
  )
}
