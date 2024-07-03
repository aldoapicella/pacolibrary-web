document.addEventListener('DOMContentLoaded', () => {
    const tabs = document.querySelectorAll('.tab-link');
    const contents = document.querySelectorAll('.tab-content');

    tabs.forEach(tab => {
        tab.addEventListener('click', () => {
            tabs.forEach(t => t.classList.remove('current'));
            contents.forEach(c => c.classList.remove('current'));
            
            tab.classList.add('current');
            document.getElementById(tab.getAttribute('data-tab')).classList.add('current');
        });
    });
});