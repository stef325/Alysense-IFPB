import React from 'react';

export default props => {

    const rows = props.collection.map(item => {
        return (
            <div>
                <div class="card border-primary mb-3" onClick={e => props.openModalInfo(item.id)}>
                    <div class="card-header">Amostra: {item.id}</div>
                    <div class="card-body">
                        <h4 class="card-title">Nota Média: {item.media}</h4>
                       
                    </div>
                </div>
            </div>

        )
    }

    )

    return(
        <div>
            {rows}
        </div>
    )


}