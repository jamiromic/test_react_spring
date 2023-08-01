import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import Automobile from '../components/Automobile';

export default function Home() {
  const [data, setData] = useState([]);

  useEffect(() => {
    // Effettua la chiamata Axios quando il componente viene montato
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/automobile/getall');
      setData(response.data);
    } catch (error) {
      console.error('Errore durante la chiamata API:', error);
    }
  };

  return (
    <div className='d-flex flex-column text-center'>
      <div className='d-flex flex-wrap'>
        {data.map((item, index) => (
          <Automobile
            key={index}
            marca={item.marca}
            colore={item.colore}
            alimentazione={item.alimentazione}
            annoImmatricolazione={item.annoImmatricolazione}
          />
        ))}
      </div>
      <Link to={"/add"}>Inserisci automobile</Link>
    </div>
  );
};
