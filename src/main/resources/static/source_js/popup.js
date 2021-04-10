const openModalButtons = document.querySelectorAll('[data-modal-target]');
const closeModalButtons = document.querySelectorAll('[data-close-btn]');
const overlay = document.getElementById('modal_overlay');

openModalButtons.forEach(button => {
    button.addEventListener('click', () => {
        const modal = document.querySelector(button.dataset.modalTarget);
        openModal(modal)
    });
});

overlay.addEventListener('click', () => {
    const modals = document.querySelectorAll('.modal_addTicket.activeM');
    modals.forEach(modal => {
        closeModal(modal);
    });
});

closeModalButtons.forEach(button => {
    button.addEventListener('click', () => {
        const modal = button.closest('.modal_addTicket')
        closeModal(modal)
    });
});

function openModal(modal) {
    if (modal == null) return;
    modal.classList.add('activeM');
    overlay.classList.add('activeO');
}

function closeModal(modal) {
    if (modal == null) return;
    modal.classList.remove('activeM');
    overlay.classList.remove('activeO');
}

