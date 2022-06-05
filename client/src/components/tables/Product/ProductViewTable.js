import React from 'react';
import { MdDeleteForever } from "react-icons/md";
import { FiEdit } from "react-icons/fi";
export default props =>{

    const rows = props.collection.map(item=>{
            return(
                <tr key={item.name} className="table-primary">
                    <td>{item.name}</td>
                    <td>{item.owner}</td>
                    <td>{item.expirationDate}</td>
                    <td>
                        <button type='button' title='Editar' className='btn btn-info' onClick={e =>props.edit()}>
                        <  FiEdit size={20} />
                        
                        </button>
                        <button type='button' title='Excluir' className='btn btn-danger' onClick={e =>props.remove(item.name)}>
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
                    <th scope='col'>Nome</th>
                    <th scope='col'>Fornecedor</th>
                    <th scope='col'>Data de validade</th>
                    <th scope='col'></th>
                    
                </tr>
            </thead>
            <tbody>
                {rows}
                <tr key="aa" className="table-primary">
                    <td>"bb"</td>
                    <td>"cc"</td>
                    <td>"dd"</td>
                    <td>
                        <button type='button' title='Editar' className='btn btn-info' >
                        <  FiEdit size={20} />
                        </button>
                        <button type='button' title='Excluir' className='btn btn-danger' >
                        < MdDeleteForever size={25}/>
                        </button>
                        
                    </td>
                </tr>
            </tbody>
        </table>
    )
}