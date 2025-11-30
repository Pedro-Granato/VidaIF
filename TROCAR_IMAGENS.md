# 🖼️ Como Trocar Imagens no Android Studio

## 📍 Onde Ficam as Imagens

```
app/src/main/res/drawable/
```

---

## 🔄 Como Trocar a Imagem do Destaque 1

### **Método 1: Pelo Android Studio (Mais Fácil)**

1. **Salvar a foto que você quer usar:**
   - Clique com botão direito na foto
   - Salvar como: `destaque1_nova.jpg`
   - Salvar na área de trabalho

2. **No Android Studio:**
   - No painel esquerdo, abrir: `app → res → drawable`
   - Clicar com botão direito na pasta `drawable`
   - Escolher: **"Show in Explorer"** (Windows) ou **"Reveal in Finder"** (Mac)

3. **Na pasta que abrir:**
   - **Deletar** o arquivo `destaque1.jpg` (antigo)
   - **Copiar** sua foto nova para essa pasta
   - **Renomear** sua foto para: `destaque1.jpg`

4. **Voltar no Android Studio:**
   - Clicar com botão direito na pasta `drawable`
   - Escolher: **"Synchronize"** ou pressionar `Ctrl+Alt+Y`

5. **Rebuild:**
   ```
   Build → Rebuild Project
   ```

6. **Rodar app**

---

### **Método 2: Copiar e Colar Direto**

1. **Localizar pasta drawable:**
   ```
   C:\Users\SeuNome\AndroidStudioProjects\VidaIF\app\src\main\res\drawable\
   ```

2. **Deletar:** `destaque1.jpg`

3. **Colar** sua nova foto

4. **Renomear** para: `destaque1.jpg`

5. **No Android Studio:** `File → Sync Project with Gradle Files`

6. **Rodar app**

---

## ⚠️ Regras Importantes para Imagens

### **Nome do arquivo DEVE:**
- ✅ Ser minúsculo: `destaque1.jpg`
- ✅ Sem espaços: `foto_ifsp.jpg`
- ✅ Sem caracteres especiais: `destaque_1.jpg`
- ❌ **NÃO PODE:**
  - `Destaque 1.jpg` (tem espaço e maiúscula)
  - `foto-IFSP.jpg` (tem maiúscula)
  - `imagem (1).jpg` (tem parênteses)

### **Formatos aceitos:**
- ✅ `.jpg` ou `.jpeg`
- ✅ `.png`
- ✅ `.webp`

### **Tamanho recomendado:**
- **Banners:** 1920x600 pixels (ou proporção 16:5)
- **Destaques:** 800x600 pixels (ou proporção 4:3)
- **Peso:** Menos de 500KB cada

---

## 🎨 O Que Mudei Agora

### **Antes (cortava):**
```xml
android:scaleType="centerCrop"
```
→ Imagem enchia toda área, cortando partes

### **Depois (não corta):**
```xml
android:scaleType="fitCenter"
android:adjustViewBounds="true"
```
→ Imagem se ajusta sem cortar, mostrando tudo

---

## 📋 Lista de Todas as Imagens

### **Banners (Carrossel Principal):**
```
📁 drawable/
  ├─ banner1.jpeg    ← Banner 1
  ├─ banner2.png     ← Banner 2
  ├─ banner3.jpg     ← Banner 3
  ├─ banner4.jpeg    ← Banner 4
  └─ banner5.jpg     ← Banner 5
```

### **Destaques:**
```
📁 drawable/
  ├─ destaque1.jpg   ← Destaque 1 (VOCÊ QUER TROCAR ESTE!)
  ├─ destaque2.jpeg  ← Destaque 2
  └─ destaque3.jpg   ← Destaque 3
```

---

## 🚀 Passo a Passo Rápido

### **Para trocar destaque1:**

```
1. Salvar sua foto como: destaque1.jpg
2. Ir em: app/res/drawable (no Android Studio)
3. Botão direito → Show in Explorer
4. Deletar destaque1.jpg antigo
5. Colar destaque1.jpg novo
6. Android Studio: Ctrl+Alt+Y (Sync)
7. Build → Rebuild Project
8. ▶️ Run
```

---

## 💡 Dicas

### **Otimizar imagens antes de adicionar:**

1. **Redimensionar** para tamanho adequado
2. **Comprimir** para menos de 500KB
3. **Converter** para `.webp` (menor tamanho)

### **Ferramentas online:**
- https://tinypng.com/ (comprimir)
- https://www.iloveimg.com/ (redimensionar)
- https://squoosh.app/ (converter para webp)

---

## 🎯 Depois de Trocar as Imagens

1. **Sempre fazer Rebuild:**
   ```
   Build → Rebuild Project
   ```

2. **Se não aparecer:**
   ```
   File → Invalidate Caches → Invalidate and Restart
   ```

3. **Testar no app**

---

## 🐛 Problemas Comuns

### **Imagem não aparece:**
- ✅ Verificar nome (minúsculo, sem espaços)
- ✅ Fazer Sync (Ctrl+Alt+Y)
- ✅ Fazer Rebuild

### **Imagem cortada:**
- ✅ Já arrumei! Agora usa `fitCenter`
- ✅ Se ainda cortar, verificar proporção da imagem

### **App não compila:**
- ✅ Verificar nome do arquivo
- ✅ Deletar arquivo `.png` duplicado
- ✅ Clean Project + Rebuild

---

## 📱 Resultado Esperado

### **Antes (centerCrop):**
```
┌────────────────┐
│   [CORTADO]    │  ← Partes da imagem cortadas
│  ████████████  │
│   [CORTADO]    │
└────────────────┘
```

### **Depois (fitCenter):**
```
┌────────────────┐
│                │  ← Espaço vazio (se necessário)
│  ██████████    │  ← Imagem completa visível
│                │
└────────────────┘
```

---

**Conseguiu entender como trocar? Me avise se precisar de ajuda!** 😊
