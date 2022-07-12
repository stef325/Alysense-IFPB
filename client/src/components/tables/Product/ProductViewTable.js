import React from 'react';
import { MdDeleteForever } from "react-icons/md";
import { FiEdit } from "react-icons/fi";
import WhitoutButtonTable from '../charact/WhitoutButtonTable';

import Modal from 'react-modal';
export default props => {



    const rows = props.collection.map(item => {
        return (
            <tr key={item.id} className="table-primary" >
                <Modal
                    isOpen={props.isVisibleProdInfo}
                    onRequestClose={props.closeModalProdInfo}
                    style={{
                        overlay: {
                            position: 'fixed',
                            zIndex: 1020,
                            top: 0,
                            left: 0,
                            width: '100vw',
                            height: '100vh',
                            background: 'rgba(235,104,100, 0.75)',
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                        },
                        content: {
                            background: 'white',
                            width: '70vw',
                            height: '60vh',
                            maxWidth: 'calc(100vw - 2rem)',
                            maxHeight: 'calc(100vh - 2rem)',
                            overflowY: 'hidden',
                            position: 'relative',
                            border: '1px solid #ccc',
                            borderRadius: '0.3rem',
                        }
                    }}
                >
                    <div className="modalContent" id="modalContent">
                        <div className="close-button">
                            <button onClick={props.closeModalProdInfo} className="btn btn-primary">x</button>
                        </div>
                        <div>
                            <h5>Nome: {item.name}</h5>
                            <hr/>
                            <h5>Data de validade: {`${item.expirationDate[2] < 10 ? "0" + item.expirationDate[2] : item.expirationDate[2]}/${item.expirationDate[1] < 10 ? "0" + item.expirationDate[1] : item.expirationDate[1]}/${item.expirationDate[0]}`}</h5>
                            <h5>Ingredientes: {item.ingredients}</h5>
                            <hr/>
                            <h5>Características</h5>
                            <WhitoutButtonTable collection={item.characteristics}></WhitoutButtonTable>

                        </div>

                    </div>


                </Modal>
                <td>{item.name}</td>
                <td>{item.owner}</td>
                <td>{`${item.expirationDate[2] < 10 ? "0" + item.expirationDate[2] : item.expirationDate[2]}/${item.expirationDate[1] < 10 ? "0" + item.expirationDate[1] : item.expirationDate[1]}/${item.expirationDate[0]}`}</td>
                <td>
                    <button type='button' title='Editar' className='btn btn-info' onClick={e => props.edit(item.id)}>
                        <  FiEdit size={20} />

                    </button>
                    <button type='button' title='Excluir' className='btn btn-danger' onClick={e => props.remove(item.id)}>
                        < MdDeleteForever size={25} />
                    </button>
                    <button type='button' title='Excluir' className='btn btn-success' onClick={e => props.showModalProduct()}>
                        i
                    </button>

                </td>
            </tr>

        )
    }

    )

    return (

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
            </tbody>
        </table>
    )
}