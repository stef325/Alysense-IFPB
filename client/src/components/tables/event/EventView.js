import React from 'react';
import { MdDeleteForever } from "react-icons/md";
import { FiEdit } from "react-icons/fi";

export default props =>{
    

    const rows = props.collection.map(item=>{
            return(
                <tr key={item.id}>
                    <td>{item.title}</td>
                    <td>{item.local}</td>
                    <td>{`${item.date[2]<10? "0"+item.date[2]:item.date[2]}/${item.date[1]<10? "0"+item.date[1]:item.date[1]}/${item.date[0]}`}</td>
                    <td>
                        <button type='button' title='Editar' className='btn btn-info' onClick={e =>props.edit(item.id)}>
                        <  FiEdit size={20} />
                        </button>
                        <button type='button' title='Excluir' className='btn btn-danger' onClick={e =>props.remove(item.id)}>
                        < MdDeleteForever size={25}/>
                        </button>
                        
                    </td>
                </tr>

            )
        }

    )

    return(
        <table className='table table-hover'>
            <thead>
                <tr>
                    <th scope='col'>Título</th>
                    <th scope='col'>Local</th>
                    <th scope='col'>Data do Evento</th>
                    <th scope='col'></th>
                    
                </tr>
            </thead>
            <tbody>
                {rows}
            </tbody>
        </table>
    )
}