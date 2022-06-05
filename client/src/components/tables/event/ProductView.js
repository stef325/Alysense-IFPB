import React from 'react';

export default props =>{

    const rows = props.collection.map(item=>{
            return(
                <tr key={item.title}>
                    <td>{item.title}</td>
                    <td>{item.local}</td>
                    <td>{item.date}</td>
                    <td>
                        <button type='button' title='Editar' className='btn btn-info' onClick={e =>props.edit()}>
                            <i className='pi pi-pencil'></i>
                        </button>
                        <button type='button' title='Excluir' className='btn btn-danger' onClick={e =>props.remove(item.name)}>
                            <i className='pi pi-trash'></i>
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