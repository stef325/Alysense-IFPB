import React from 'react';

export default props =>{

    const rows = props.collection.map(item=>{
            return(
                <tr key={item.atribute}>
                    <td>{item.atribute}</td>
                    <td>
                        <button type='button' title='Excluir' className='btn btn-danger' onClick={e =>props.remove(item.atribute)}>
                            <i className='pi pi-trash'></i>
                        </button>
                    </td>
                </tr>

            )
        }

    )

    return(
        <table className='table table-hover'>
            <tbody>
                {rows}
            </tbody>
        </table>
    )
}