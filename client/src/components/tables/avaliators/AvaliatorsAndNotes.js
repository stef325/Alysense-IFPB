import React from 'react';

export default props =>{

    const rows = props.collection.map(avaliator=>{
            return(
                <tr key={avaliator.id}>
                    <td>{avaliator.name}</td>
                    <td>{avaliator.note}</td>
                </tr>

            )
        }

    )

    return(
        <table className='table table-hover'>
            <thead>
                <tr>
                    <th scope='col'>Nome</th>
                    <th scope='col'>Nota</th>
                    
                </tr>
            </thead>
            <tbody>
                {rows}
            </tbody>
        </table>
    )
}