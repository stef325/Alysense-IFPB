import React from 'react';

import ResultCard from '../../../components/cards/ResultCard';
import "./ResultStyle.css"
import Modal from 'react-modal';

import AvaliatorsAndNotes from '../../../components/tables/avaliators/AvaliatorsAndNotes'

export default class Result extends React.Component {

    state = {
        product: {
            name: "cabo de vassoura",
            amostra: 1
        },
        samples: [
            {
                id: 1,
                media: 5
            }
            , {
                id: 4,
                media: 2
            }
        ],
        isVisibleInfo: false,
        AvaliatorsAndNotes:[
            {
                name:"maria",
                note:3
            },
            {
                name:"joão",
                note:7
            }
        ]



    }
    componentDidMount() {
        Modal.setAppElement('#root');
        this.setState({ isVisibleInfo: false })

    }
    closeModalInfo = () => {
        this.setState({ isVisibleInfo: false })
    }



    openModalInfo = (itemID) => {
        this.setState({ isVisibleInfo: true })
    }


    render() {
        return (
            <div>
                <div className='result-container'>

                    <div className="card border-secondary mb-3">
                        <div className="card-body card-header-body">
                            <h2>Produto: {this.state.product.name}</h2>
                        </div>
                    </div>
                    <Modal
                        isOpen={this.state.isVisibleInfo}
                        onRequestClose={this.closeModalInfo}
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
                                width: '57vw',
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
                                <button onClick={this.closeModalInfo} className="btn btn-primary">x</button>
                            </div>
                            <h4>Avaliadores e notas</h4>
                            <AvaliatorsAndNotes collection={this.state.AvaliatorsAndNotes}></AvaliatorsAndNotes>


                        </div>


                    </Modal>
                    <ResultCard collection={this.state.samples} openModalInfo={this.openModalInfo}></ResultCard>


                </div>
            </div>
        )
    }
}