import { Button } from "primereact/button";
import React from "react";

// Define o tipo das props esperadas pelo componente
interface ColunaOpcoesProps {
    rowData: any; // ou se você tiver um tipo para os dados da tabela, coloque aqui no lugar de any
    editObjeto: (data: any) => void;
    confirmDeleteObjeto: (data: any) => void;
  }
  
  // Componente tipado
  const ColunaOpcoes = (props: ColunaOpcoesProps) => {
    // Desestrutura as props
    const { rowData, editObjeto, confirmDeleteObjeto } = props;
  
    return (
      <div className="actions">
        {/* Botão para editar objeto */}
        <Button
          icon="pi pi-pencil"
          className="p-button-rounded p-button-success mr-2"
          onClick={() => editObjeto(rowData)}
        />
        
        {/* Botão para excluir objeto */}
        <Button
          icon="pi pi-trash"
          className="p-button-rounded p-button-danger mt-2"
          onClick={() => confirmDeleteObjeto(rowData)}
        />
      </div>
    );
  };
  

export default ColunaOpcoes;