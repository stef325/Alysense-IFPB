import React from 'react';

export default props =>{

    const rows = props.collection.map(item=>{
            return(
                <tr key={item.atribute}>
                    <td>{item.atribute}</td>
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