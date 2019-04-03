import tkinter as tk
from main_client import chat_backend

def create_chat_window():
    main_window = tk.Tk()
    main_window.geometry('420x450')
    main_window.title('Chat window')
    create_top_frame(main_window)
    create_bottom_frame(main_window)
    main_window.mainloop()

def create_top_frame(window):
    top_frame = tk.Frame(window, name='top_frame', relief=tk.GROOVE, bg='green', height=300, width=400)    
    conversation_view = tk.Text(top_frame, name='conversation_view', width=49, wrap=tk.WORD)
    v_scroller = tk.Scrollbar(window, name='v_scroller')
    conversation_view.config(yscrollcommand=v_scroller.set)
    v_scroller.config(command=conversation_view.yview)
    v_scroller.pack(side='right',fill='y')
    conversation_view.pack(expand=1, fill='both')
    top_frame.place(x=10, y=10)

def create_bottom_frame(window):        
    bottom_frame = tk.Frame(window, name='bottom_frame', height=100, width=397)
    message_box = tk.Text(bottom_frame, name='message_box')
    send_btn = tk.Button(bottom_frame, name='send_btn', text='Send', command = lambda:send_btn_click_handler(message_box, window))
    message_box.place(x=0,y=0)
    send_btn.place(x=355,y=75)
    bottom_frame.place(x=10, y=320)
    
def send_btn_click_handler(message_box, window):
    message = message_box.get('1.0',tk.END)
    ((window.children['top_frame']).children['conversation_view']).insert(tk.END, 'You: '+ message + '\n')
    message_box.delete('1.0',tk.END)
    backend_obj = chat_backend()
    data = backend_obj.send_message(message)
    print(data.decode('ascii'))
    
    
if __name__ == '__main__':
    create_chat_window()
    