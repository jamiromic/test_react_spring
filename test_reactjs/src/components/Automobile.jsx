import React from 'react'

export default function Automobile(props) {
  return (
    <div className='card text-center m-5' style={{width: '180px'}}>
        <h2>{props.marca}</h2>
        <p>{props.alimentazione}</p>
        <p>{props.annoImmatricolazione}</p>
        <p>{props.colore}</p>
    </div>
  )
}
