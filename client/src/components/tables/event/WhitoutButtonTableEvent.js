import React from 'react';

export default props =>{

    const rows = props.collection.map(item=>{
            return(
                <tr key={item.id}>
                    <td>{item.name}</td>
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